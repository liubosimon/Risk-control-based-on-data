package feature;

import java.util.Enumeration;

import weka.attributeSelection.InfoGainAttributeEval;
import weka.core.Attribute;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.NumericToNominal;

public class UseInfoGain {

	public static double computeInfoGain(Instances data, Attribute att) throws Exception {
		double infoGain = computeEntropy(data);
		Instances[] splitData = splitData(data, att);
		for (int j = 0; j < data.numDistinctValues(att); j++) {
			if (splitData[j].numInstances() > 0) {
				infoGain -= ((double) splitData[j].numInstances() / (double) data.numInstances())
						* computeEntropy(splitData[j]);
			}
		}
		return infoGain;
	}


	public static double computeEntropy(Instances data) throws Exception {
		double[] classCounts = new double[data.numClasses()];
		Enumeration instEnum = data.enumerateInstances();
		while (instEnum.hasMoreElements()) {
			Instance inst = (Instance) instEnum.nextElement();
			classCounts[(int) inst.classValue()]++;
		}
		double entropy = 0;
		for (int j = 0; j < data.numClasses(); j++) {
			if (classCounts[j] > 0) {
				entropy -= classCounts[j] * Utils.log2(classCounts[j]);
			}
		}
		entropy /= (double) data.numInstances();
		return entropy + Utils.log2(data.numInstances());
	}


	public static Instances[] splitData(Instances data, Attribute att) {
		int size=data.numDistinctValues(att);
		Instances[] splitData = new Instances[size];
		for (int j = 0; j < size; j++) {
			splitData[j] = new Instances(data, data.numInstances());
		}
		Enumeration instEnum = data.enumerateInstances();
		while (instEnum.hasMoreElements()) {
			Instance inst = (Instance) instEnum.nextElement();
			splitData[(int) inst.value(att)].add(inst);
		}
		for (int i = 0; i < splitData.length; i++) {
			splitData[i].compactify();
		}
		return splitData;
	}
	public static void main(String[] args)throws Exception {

		Instances train = DataSource.read("G:\\����\\΢�����û���ƷԤ��\\train_xy.csv");
		train.setClassIndex(train.numAttributes()-1);
		NumericToNominal filter = new NumericToNominal();
		String options2[] = new String[2];
		options2[0] = "-R";
		options2[1] = "last";
		filter.setOptions(options2);
		filter.setInputFormat(train);
		train=Filter.useFilter(train, filter);
		int index=10;
		System.out.println(UseInfoGain.computeInfoGain(train, train.attribute(index)));

		InfoGainEval in=new InfoGainEval();
		System.out.println(in.computeInfoGain(train, index)) ;

	}
}

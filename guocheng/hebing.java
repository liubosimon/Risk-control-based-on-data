package proccess;
import util.Util;
import weka.core.Instances;

public class CombineSample {
	public static void main(String[] args)throws Exception {
		Instances data=Util.getInstances("D:/8file_train.csv");
		Instances sa=Util.getInstances("G:\\sample400.csv");
		data=Util.addAll(data,sa);
		Util.saveIns(data, "D:/8file_train_sample.csv");
	}
}

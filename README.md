# Risk-control-based-on-data
The project uses historical user behavior data to predict the probability of default or default within the next six months.

数据风控项目：
该项目以用户历史行为数据来预测其在未来 6 个月内会否违约或者逾期的概率。
guocheng文件夹
- fenkuai.java 对采样数据进行分块
- CombineSample.java 合并采样数据
- bingxingRNB.java和bingxingMatrix.java用于并行采样代码的工具


- feature gongcheng  文件夾	
- nodiscrete.java和featureforcity.java对城市的向量特征进行计算
- featureofcity.sql 为数据库处理代码
- paixun.py  把原始的特征进行排序处理
- nullhandle.py 处理缺失值
- jingweidu.py  产生经纬度特征
-handlefeature.py 对于特征进行处理
- hebingfeature.py	特征合并
- xuan zhe feature.py	特征筛选
- jgh文件夹
- user log Info feature.java	  用于提取登陆的信息特征
- user update info feature.java 用于修改和提取信息特征
- merge.java	  用于融合模型工具
- feature process.java	特征处理类


- feature_xuanzhe 文件夹`
- using_xgb_xuanzhe_feature.py  训练xgb模型对特征进行重要性排序，特征选择 利用xgb模型对特征重要性排序并选择
- quanbu_featurescore.py  合并featurescore文件，从而获得完整特征正要性文件

	
-yangping  文件夹
包含了两种采样代码


- tl  文件夹
- null_see.py 用于对缺失值进行可视化的分析
- vis_data.py  用于可视化分析每日的成交以及违约量
- importance for feature.py 对特征重要性进行绘图
- auc.py 计算准确度

	
- logic文件夹
- logic.py   逻辑回归模型

	
- svm 文件夹
- svm.py  对数据集进行分解从而训练多个svm
- val.py  用于在验证集上查看效果
- avg_test.py  用于在测试集上查看效果
	
	

- xgb文件夹
- xgb for single.py  单模型的xgboost
- xgb fo bagging.py  把随机扰动加入到参数和特征中，对多个xgboost子模型进行训练
- test for avg.py  averaging模型的预测结果
- xgboost for graphlab.py  xgboost的graphlab版


- esble文件夹
- mic cal.py 计算单模型结果文件之间的相关性   用于对单模型之间的相关性进行计算
- esble.py  加权融合多个单模型，从而选取最优参数
- blend.py  用blending融合多个单模型
	


	

#coding=utf-8

import pandas as pd







train_x = pd.read_csv('../data/train/train_master.csv',encoding='gb18030')
train_x.fillna(-1,inplace=True)
test_x = pd.read_csv('../data/test/Kesci_Master_9w_gbk_1_test_set.csv',encoding='gb18030')
test_x.fillna(-1,inplace=True)

train_x['n_null'] = (train_x<0).sum(axis=1)
test_x['n_null'] = (test_x<0).sum(axis=1)


train_x['discret_null'] = train_x.n_null
train_x.discret_null[train_x.discret_null<=24] = 1
train_x.discret_null[(train_x.discret_null>24)&(train_x.discret_null<=34)] = 2
train_x.discret_null[(train_x.discret_null>34)&(train_x.discret_null<=46)] = 3
train_x.discret_null[(train_x.discret_null>46)&(train_x.discret_null<=51)] = 4
train_x.discret_null[(train_x.discret_null>51)] = 5
train_x[['Idx','n_null','discret_null']].to_csv('../data/train/train_x_null.csv',index=None)

test_x['discret_null'] = test_x.n_null
test_x.discret_null[test_x.discret_null<=24] = 1
test_x.discret_null[(test_x.discret_null>24)&(test_x.discret_null<=34)] = 2
test_x.discret_null[(test_x.discret_null>34)&(test_x.discret_null<=46)] = 3
test_x.discret_null[(test_x.discret_null>46)&(test_x.discret_null<=51)] = 4
test_x.discret_null[(test_x.discret_null>51)] = 5
test_x[['Idx','n_null','discret_null']].to_csv('../data/test/test_x_null.csv',index=None)





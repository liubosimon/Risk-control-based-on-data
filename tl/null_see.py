#coding=utf-8


import numpy as np
import pandas as pd
import matplotlib.pylab as plt

train = pd.read_csv('../data/train/train_x_null.csv')[['Idx','n_null']]
train_y = pd.read_csv('../data/train/train_master.csv',encoding='gb18030')[['Idx','target']]
train = pd.merge(train,train_y,on='Idx')
train = train.sort(columns='n_null')
train_missing_gt130= train[train.n_null>130]
train_missing_gt130.to_csv('../data/train_missing_gt130.csv',index=None)

print (len(train_missing_gt130))

test = pd.read_csv('../data/test/test_x_null.csv')[['Idx','n_null']]
test = test.sort(columns='n_null')

t = train.n_null.values
x = range(len(t))
plt.scatter(x,t,c='k')
plt.title('train set')
plt.xlabel('Order Number(sort increasingly)')
plt.ylabel('Number of Missing Attributes')  
plt.ylim(0,170) 
plt.show()

t = test.n_null.values
x = range(len(t))
plt.scatter(x,t,c='b')
plt.title('test set')
plt.ylim(0,170) 
plt.xlabel('Order Number(sort increasingly)')
plt.ylabel('Number of Missing Attributes')
plt.show()



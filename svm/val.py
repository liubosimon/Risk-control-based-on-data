#coding=utf-8


from sklearn.metrics import roc_auc_score
import pandas as pd 
import os
val = pd.read_csv('../data/validation/validation_set.csv')

files = os.listdir('./val')
pred = pd.read_csv('./val/'+files[0])
Idx = pred.Idx
score = pred.score
for f in files[1:]:
    pred = pd.read_csv('./val/'+f)
    score += pred.score
score /= len(files)
pred = pd.DataFrame(Idx,columns=['Idx'])
pred['score'] = score
tmp = pd.merge(pred,val,on='Idx')

auc = roc_auc_score(tmp.target.values,tmp.score.values)
pred.to_csv('./val/avg_{0}.csv'.format(auc),index=None,encoding='utf-8')

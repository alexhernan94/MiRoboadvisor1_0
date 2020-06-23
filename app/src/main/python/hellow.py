#https://medium.com/pursuitnotes/k-means-clustering-model-in-6-steps-with-python-35b532cfa8ad
import pickle

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from sklearn.cluster import KMeans
from sklearn import preprocessing

data = pd.read_csv('Clientes.csv', sep=';')
data

x = data.copy()
kmeans = KMeans(5).fit(x)

cluster = x.copy()
cluster['Riesgo'] = kmeans.fit_predict(x)

plt.scatter(cluster['Age'], cluster['Income'], cluster['Score'],  c=cluster['Riesgo'], cmap='rainbow')
plt.ylabel('Spending Score (1-100)')
plt.xlabel('Age')
plt.show()

x_scaled = preprocessing.scale(x)
print(x_scaled)

wcss = []

for i in range(1, 100):
    kmeans = KMeans(i)
    kmeans.fit(x_scaled)
    wcss.append(kmeans.inertia_)
print(wcss)

plt.plot(range(1, 100), wcss)
plt.xlabel('Clusters')
plt.ylabel('WCSS')
plt.show()


kmeans_new = KMeans(7)
kmeans.fit(x_scaled)
cluster_new = x.copy()
cluster_new['Riesgo'] = kmeans_new.fit_predict(x_scaled)
print(cluster_new)

pickle.dump(kmeans_new, open("modelo.pkl", "wb"))

plt.scatter(cluster_new['Age'], cluster_new['Income'], cluster_new['Score'], c=cluster_new['Riesgo'], cmap='rainbow')
plt.ylabel('Spending Score (1-100)')
plt.xlabel('Age')
plt.show()


#Exportacion JSON
cluster_new.to_json('modelo.json', orient='records')

#Exportacion CSV
cluster_new.to_csv('modelo.csv', sep=';', index_label="id_cliente")

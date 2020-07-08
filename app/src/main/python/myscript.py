import pandas as pd
from os.path import dirname, join
import pickle

def classification(edad, ingresos, ahorros):

    #data = pd.read_csv(join(dirname(__file__), 'Clientes.csv'), sep=';')
    #data2 = open(join(dirname(__file__), 'modelo.pkl'), 'rb')
    classifier = train()
    score = (ahorros/(ingresos*edad))*100
    hola = classifier.predict([[edad, ingresos, score]])
    print (hola)
    print ("------------------------------------clas leido-------------------------------------")
    print (edad)
    print (ingresos)
    print (ahorros)

    return hola[0]

def train():

    import pandas as pd
    from sklearn.neighbors import KNeighborsClassifier

    #Lectura del dataset
    data = pd.read_csv(join(dirname(__file__), 'Clientes.csv'), sep=';')

    #Agrupacion en clusters
    x = data[["Age", "Income", "Score"]].copy()
    y = data[["Fondos"]].copy()


    #Agrupacion de nuevo en clusters
    kmeans_new = KNeighborsClassifier(n_neighbors=27)
    kmeans_new.fit(x, y.values.ravel())

    return kmeans_new

import pandas as pd
from os.path import dirname, join

def test(edad, ingresos, ahorros):
    import pickle
    print ("------------------------------------Leyendo archivos-------------------------------------")
    data = pd.read_csv(join(dirname(__file__), 'Clientes.csv'), sep=';')
    data2 = open(join(dirname(__file__), 'modelo.pickle'), 'rb')
    print ("------------------------------------Clientes-------------------------------------")
    print (data)
    print ("------------------------------------Modelo-------------------------------------")
    print (data2)
    classifier = pickle.load(data2)
    print ("------------------------------------Pickle-------------------------------------")
    print (classifier)
    print ("------------------------------------Clientes leido-------------------------------------")
    score = (ahorros/(ingresos*edad))*100
    hola = classifier.predict([[edad, ingresos, score]])
    print ("------------------------------------class-------------------------------------")
    print (hola)
    print ("------------------------------------clas leido-------------------------------------")
    print (edad)
    print (ingresos)
    print (ahorros)

    return edad
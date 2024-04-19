#!/bin/bash

# Compilar el programa Main.java con javac
javac Main.java

# Verificar si la compilación fue exitosa
if [ $? -eq 0 ]; then
    echo "Compilación exitosa. Ejecutando programa..."
    
    # Ejecutar el programa Main con el archivo config.csv como argumento
    java Main config.csv
    
    # Eliminar el archivo Main.class
    rm Main.class
else
    echo "Error de compilación."
fi

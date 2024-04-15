# Nombre del archivo .java sin la extensión
MAIN = Main

# Comando para compilar
JAVAC = javac

# Comando para ejecutar
JAVA = java

# Opciones del compilador
JFLAGS = -g

# Archivos .java
SOURCES = $(wildcard *.java)

# Archivos .class generados
CLASSES = $(SOURCES:.java=.class)

# Regla para construir el programa
$(MAIN): $(CLASSES)
	@echo "Compilación finalizada. Ejecuta con: make run"

# Regla para compilar los archivos .java
%.class: %.java
	$(JAVAC) $(JFLAGS) $<

# Regla para ejecutar el programa
run: $(MAIN)
	$(JAVA) $(MAIN)

# Regla para limpiar archivos generados
clean:
	$(RM) $(CLASSES)

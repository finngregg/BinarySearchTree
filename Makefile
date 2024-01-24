JFLAGS = -g
JC = javac
BINDIR=./bin
SRCDIR=./src
DOCDIR=./javadocs

.SUFFIXES: .java .class

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JC) -d $(BINDIR)/ -cp $(BINDIR):$(SRCDIR) $<

CLASSES = LS.class BinaryTreeNode.class BTQueueNode.class BTQueue.class BinaryTree.class BinarySearchTree.class LSArrayApp.class LSBSTApp.class LS.class


CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)
SRC_FILES=$(SRC:%.java=$(SRCDIR)/%.java)

default: $(CLASS_FILES)

run:
	java -cp $(BINDIR) LSArrayApp

docs:
	javadoc  -classpath ${BINDIR} -d ${DOCDIR} ${SRCDIR}/*.java

clean:
	rm -f ${BINDIR}/*.class

cleandocs:
	rm -rf ${DOCDIR}/*

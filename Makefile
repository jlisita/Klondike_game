JFLAGS = -g
JC = javac
SRCDIR=src
BINDIR=bin
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java -classpath $(SRCDIR) -d $(BINDIR)

CLASSES = \
		$(SRCDIR)/Value.java \
		$(SRCDIR)/Color.java \
		$(SRCDIR)/Card.java \
		$(SRCDIR)/Pile.java \
		$(SRCDIR)/Row.java \
		$(SRCDIR)/Waste.java \
		$(SRCDIR)/Foundation.java \
		$(SRCDIR)/Tableau.java \
		$(SRCDIR)/Stock.java \
		$(SRCDIR)/Patience.java \
		$(SRCDIR)/Classmain.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
		$(RM) $(BINDIR)/*.class
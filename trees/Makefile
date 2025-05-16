CC=gcc
SRC=src/main
DEPS=src/headers
SRS=$(SRC)/pilot.c $(SRC)/trees.c

pilot: $(SRS)
	$(CC) -o $@ $^ -I $(DEPS) -g
clean:
	rm pilot

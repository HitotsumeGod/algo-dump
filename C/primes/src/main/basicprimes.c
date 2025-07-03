#include <stdio.h>
#include <stdint.h>
#include <stdbool.h>

	uint32_t n = 0;
	bool isprime;

	while (++n) {
		isprime = true;
		for (int i = 2; i < n; i++)
			if (n % i == 0) {
				isprime = false;
				break;
			}
		if (isprime)
			printf("%d is prime!\n", n);
	}


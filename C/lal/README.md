#makec generated readme

My personal linear algebra library (LAL). 
The library is predicated around a single data structure: the RMATRIX (short for Arbitrary Matrix), which represents a mathematical matrix of arbitrary dimensionality.
An RMATRIX is a struct with two members: an unsigned eight-bit integer field holding the size (in dimensions) of the RMATRIX, 
and a pointer to an MMATRIX (short for Mutable Matrix), the hidden powerhouse of the entire library, for which the RMATRIX is really only a convenient wrapper.
An MMATRIX is a two-member union whose mutable nature is demonstrated in its functionality: it has the capability to become either a vector of signed integers (MMATRIX -> vector_form),
or another MMATRIX pointer (MMATRIX -> matrix_form) which essentially always resolves to an array of MMATRIXs. 

The vector-size (v) of an RMATRIX may be calculated using the following mathematical formula, given the number of dimensions (d) and submatrix row/column size (s) that exist uniform across the RMATRIX:

f(v) = s^(d-1)

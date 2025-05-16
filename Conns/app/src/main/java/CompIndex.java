class CompIndex {

	private class NodesAlreadyConnectedException extends RuntimeException {}

	private int[] cindex;
	private int cinSize;

	CompIndex(int size) {

		this.cinSize = size;
		this.cindex = new int[cinSize];
		for (int i = 0; i < cinSize; i++)
			this.cindex[i] = i;

	}

	void connect(int p, int q) {
	
		if (this.cindex[p] == this.cindex[q])
			throw new NodesAlreadyConnectedException();
		this.cindex[p] = this.cindex[q];

	}

	boolean areConnected(int p, int q) {
		
		return this.cindex[p] == this.cindex[q];

	}

}

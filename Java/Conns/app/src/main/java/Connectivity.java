class NetComputer {

	private final String hostname;
	private final int personalIndex;

	NetComputer(String hostname, int pi) {

		this.hostname = hostname;
		this.personalIndex = pi;

	}

	String getHostname() {

		return hostname;

	}

	int getPersonalIndex() {

		return personalIndex;

	}

}

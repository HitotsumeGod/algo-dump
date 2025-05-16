public class Pilot {

	public static void main(String[] args) {

		int numCons = 100;
		CompIndex cindex = new CompIndex(numCons);
		NetComputer[] computers = new NetComputer[numCons];
		for (int i = 0; i < numCons; i++) 
			computers[i] = new NetComputer("Argos" + i, i);
		cindex.connect(computers[6].getPersonalIndex(), computers[10].getPersonalIndex());
		System.out.println(cindex.areConnected(computers[6].getPersonalIndex(), computers[10].getPersonalIndex()));
		for (NetComputer nc : computers)
			System.out.println(nc.getHostname());

	}


}

public class test {

	public static void main(String[] args) {
		DatabaseConnector dbc = new DatabaseConnector();
		String fpath = "importFile.txt";
		try {
			dbc.importFromFile(fpath);
			dbc.getStatitics();
			for (SinhVien s : StatisticsResult.dssv) {
				System.out.println(s.toString());
			}
			for (GiangVien g : StatisticsResult.dsgv) {
				System.out.println(g.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

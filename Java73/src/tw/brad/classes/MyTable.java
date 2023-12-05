package tw.brad.classes;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyTable extends JTable {
	private MyModel myModel;
	private FoodDB foodDb;
	
	public MyTable() {
		
		try {
			foodDb = new FoodDB();
			foodDb.queryDB();
		} catch (Exception e) {

		}
		
		myModel = new MyModel();
		setModel(myModel);
	}
	
	private class MyModel extends DefaultTableModel {

		@Override
		public int getRowCount() {
			return foodDb.getRows();
		}

		@Override
		public int getColumnCount() {
			return foodDb.getCols();
		}

		@Override
		public Object getValueAt(int row, int column) {
			return foodDb.getData(row+1, column+1);
		}

		
	}
}

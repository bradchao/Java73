package tw.brad.classes;

import java.sql.SQLException;

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
		myModel.setColumnIdentifiers(foodDb.getHeader());
		
	}
	
	public void delData() {
		try {
			System.out.println("debug1:" + foodDb.getRS().getRow());
			int n = getSelectedRow();
			System.out.println("debug2:" + foodDb.getRS().getRow());
			if (n >= 0) {
				try {
					System.out.println("debug3:" + foodDb.getRS().getRow());
					foodDb.delRow();
					repaint();
				} catch (Exception e) {
	
				}
			}
		}catch(Exception e) {}
	}
	
	public void moveNewRow() {
		foodDb.moveNewRow();
		repaint();
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

		@Override
		public void setValueAt(Object aValue, int row, int column) {
			foodDb.updateDB(row+1, column+1, (String)aValue);
		}

		@Override
		public boolean isCellEditable(int row, int column) {
			boolean isEditable = true;
			if (column == 0) isEditable = false;
			return isEditable;
		}

		
		
	}
}

////////////////////////////////////////////////////////////////////////////////
//             //                                                             //
//   #####     // Knapsack -- a simple example                                //
//  ######     // (!) 2015 Giovanni Squillero <giovanni.squillero@polito.it>  //
//  ###   \    //                                                             //
//   ##G  c\   //                                                             //
//   #     _\  //                                                             //
//   |   _/    //                                                             //
//   |  _/     //                                                             //
//             // 03FYZ - Tecniche di programmazione 2014-15                  //
////////////////////////////////////////////////////////////////////////////////

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Item;
import db.DBConnect;

public class KanpsackDAO {
	public List<Item> getItems() {
		final String sql = "SELECT * FROM objects LIMIT 45";
		List<Item> items = new ArrayList<Item>();
	
		try {
			Connection conn = DBConnect.getInstance().getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Item i = new Item(rs.getDouble("value"), rs.getDouble("weight"));
				items.add(i);
			}

			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return items;
	}
}

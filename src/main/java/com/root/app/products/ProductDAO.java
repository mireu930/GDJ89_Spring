package com.root.app.products;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.root.app.utils.DBConnection;

@Repository
public class ProductDAO {
	
	public List<ProductDTO> getList() throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		List<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		while(resultSet.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(resultSet.getLong(1));
			productDTO.setProductName(resultSet.getString(2));
			productDTO.setProductDetail(resultSet.getString(3));
			productDTO.setProductRate(resultSet.getDouble(4));
			productDTO.setProductDate(resultSet.getDate(5));
			
			ar.add(productDTO);
		}
		
		DBConnection.disConnection(resultSet, preparedStatement, connection);
		
		return ar;
	}
	
	public int add(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "INSERT INTO PRODUCTS(PRODUCTNUM, PRODUCTNAME, PRODUCTDETAIL, PRODUCTRATE, PRODUCTDATE)"
				+ " VALUES (PRODUCTNUM_SEQ.NEXTVAL,?,?,?,SYSDATE)";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setString(1, productDTO.getProductName());
		preparedStatement.setString(2, productDTO.getProductDetail());
		preparedStatement.setDouble(3, productDTO.getProductRate());
//		preparedStatement.setDate(4, productDTO.getProductDate());
		
		
		int result = preparedStatement.executeUpdate();
		
		DBConnection.disConnection(preparedStatement, connection);
		
		return result;
	}
	
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception {
		Connection connection = DBConnection.getConnection();
		String sql = "SELECT * FROM PRODUCTS WHERE PRODUCTNUM = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setLong(1, productDTO.getProductNum());
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			productDTO.setProductNum(resultSet.getLong(1));
			productDTO.setProductName(resultSet.getString(2));
			productDTO.setProductDetail(resultSet.getString(3));
			productDTO.setProductRate(resultSet.getDouble(4));
			productDTO.setProductDate(resultSet.getDate(5));
		}
		DBConnection.disConnection(resultSet, preparedStatement, connection);
		
		return productDTO;
	}
}

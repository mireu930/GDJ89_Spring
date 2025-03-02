package com.root.app.products;

import com.root.app.files.FileDTO;

public class ProductFileDTO extends FileDTO {
	private Long productNum;

	public Long getProductNum() {
		return productNum;
	}

	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
}

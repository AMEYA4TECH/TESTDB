package com;


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	ProductGetterImpl productGetterImpl;
	
	@Autowired
	ApiResponse message;
	
	@RequestMapping(value = "{xid}", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8" , "application/xml; charset=UTF-8" })
    public ResponseEntity<?> getProductJSON(@PathVariable("xid") String xid)
            throws UnsupportedEncodingException,  Exception {
    	long totalTime = System.currentTimeMillis();

        Product productResponse = null;
        if (xid == null) {
            return new ResponseEntity<Product>(productResponse, null, HttpStatus.UNAUTHORIZED);
        }
        
        try {
        	productResponse=     productGetterImpl.getProduct(xid);
            
        } catch (RuntimeException re) {
        	
        } 
        
        if(productResponse.getID()==null || productResponse.getID()==""){
        	message.setMessage("The ID " +xid+" does not exist ,Kindly provide a valid ID.");
        return	new ResponseEntity<ApiResponse>(message, null, HttpStatus.BAD_REQUEST);
        }
        totalTime = System.currentTimeMillis() - totalTime;
        
        ResponseEntity<Product> response = new ResponseEntity<Product>(productResponse, null, HttpStatus.OK);

        
        return response;
    }
	
	@RequestMapping(value = "all", method = RequestMethod.GET, produces = {"application/json; charset=UTF-8" , "application/xml; charset=UTF-8" })
    public ResponseEntity<?> getAllProductJSON( )
            throws UnsupportedEncodingException,  Exception {
    	long totalTime = System.currentTimeMillis();

      ArrayList<Product>   productResponse = null;
       /* if (xid == null) {
            return new ResponseEntity<ArrayList<Product>>(productResponse, null, HttpStatus.UNAUTHORIZED);
        }
        */
        try {
        	productResponse=     productGetterImpl.getAllProduct();
            
        } catch (RuntimeException re) {
        	
        } 
        
        if(productResponse==null || productResponse.isEmpty()){
        //	message.setMessage("The ID " +xid+" does not exist ,Kindly provide a valid ID.");
        return	new ResponseEntity<ApiResponse>(message, null, HttpStatus.BAD_REQUEST);
        }
        totalTime = System.currentTimeMillis() - totalTime;
        
        ResponseEntity<ArrayList<Product>> response = new ResponseEntity<ArrayList<Product>>(productResponse, null, HttpStatus.OK);

        
        return response;
    }
	
	@RequestMapping(method = RequestMethod.POST, headers = "content-type=application/json", produces = { "application/json; charset=UTF-8" })
	 public ResponseEntity<?> updateProduct(HttpEntity<Product> requestEntity, HttpServletRequest request) throws Exception {
	       
	        
            boolean flag=false;
	        if (requestEntity.getBody() == null) {
	            return new ResponseEntity<ApiResponse>(message, null, HttpStatus.UNAUTHORIZED);
	        } else if (requestEntity == null || requestEntity.getBody() == null) {
	            message = new ApiResponse();
	            
	            message.setMessage("Invalid request, request body can't be null");
	            return new ResponseEntity<ApiResponse>(message, null, HttpStatus.BAD_REQUEST);
	        } else if (requestEntity.getBody().getID() == null || requestEntity.getBody().getID().isEmpty()) {
	            // External ProductID required
	            message = new ApiResponse();
	            message.setMessage("Invalid request, ExternalProductId can't be null/empty");
	            
	            return new ResponseEntity<ApiResponse>(message, null, HttpStatus.BAD_REQUEST);
	        }
	         
	            //String batchId = request.getParameter("batchId");
	       flag=     productGetterImpl.postProduct(requestEntity.getBody());
	            //(authToken, batchId, requestEntity.getBody(), getIPAddress(request));
	            
	            
	            if(!flag){
	            	  
	                  message.setMessage("The XID "+requestEntity.getBody().getID()+" already exist , Kindly provide an unique XID");
	                  
	                  return new ResponseEntity<ApiResponse>(message, null,HttpStatus.BAD_REQUEST);
	            }else{
	            	message.setMessage("Your Product "+requestEntity.getBody().getName() +" saved successfully");
	            }
	        

	        return new ResponseEntity<ApiResponse>(message, null, HttpStatus.ACCEPTED);
	    }

	
	
	@RequestMapping(value = "{xid}", method = RequestMethod.DELETE, produces = {"application/json; charset=UTF-8" , "application/xml; charset=UTF-8" })
    public ResponseEntity<ApiResponse> deleteProductJSON(@PathVariable("xid") String xid)
            throws UnsupportedEncodingException,  Exception {
    	long totalTime = System.currentTimeMillis();

       
        boolean flag=false;
        if (xid == null) {
        	message.setMessage("The xid is required to delete an product");
            return new ResponseEntity<ApiResponse>(message, null, HttpStatus.UNAUTHORIZED);
        }
        
        try {
        	flag=     productGetterImpl.deleteProduct(xid);
            
        } catch (RuntimeException re) {
        	
        } 
        totalTime = System.currentTimeMillis() - totalTime;
        if(flag){
        	message.setMessage("The product with "+xid+" is deleted successfully ");
        return new ResponseEntity<ApiResponse>(message, null, HttpStatus.OK);
        }else{
        	message.setMessage("The product with "+xid+" does not exist,Please provide valid xid ");
        	return new ResponseEntity<ApiResponse>(message, null, HttpStatus.BAD_REQUEST);
        }
        
    }

	public ProductGetterImpl getProductGetterImpl() {
		return productGetterImpl;
	}

	public void setProductGetterImpl(ProductGetterImpl productGetterImpl) {
		this.productGetterImpl = productGetterImpl;
	}
	
	
	
}

package com.edigiseva.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edigiseva.message.request.DigiSevaResponseEntity;
import com.edigiseva.utils.Utilities;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/instapay")
public class InstaPayAPIs {

	@GetMapping("/instapaytransaction")
	public ResponseEntity<DigiSevaResponseEntity> instaPayTransaction() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
		
		String key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCGG4+y8hy5p3hiUfjjHTt8YEhcqfFrt4OkWwYkiHlKBQrKp1cTAWk55bvFTQPo+YAxhIAlA0ymJ0FRuNOvgTUpg1QNoE8DKqscq+oCakF1cztRrVQYjQ3gLuzhdgpjJYsGuEFoqYaGfSN103hEc7Ur8QZr9YiWpKETMy88RR082wIDAQAB";
	        PublicKey publicKey = null;
	        try{
	            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(key.getBytes()));
	            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	            publicKey = keyFactory.generatePublic(keySpec);
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        } catch (InvalidKeySpecException e) {
	            e.printStackTrace();
	        }
	        Cipher cipher = Cipher.getInstance("RSA");
	        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
	        Object customerReferenceNumber = "1234";
	        Object customerID = Base64.getEncoder().encodeToString(cipher.doFinal("TESTIMPS".getBytes("UTF-8")));
	        Object debitAccountNumber = Base64.getEncoder().encodeToString(cipher.doFinal("010405000001".getBytes("UTF-8")));
	        Object creditAccountNumber = Base64.getEncoder().encodeToString(cipher.doFinal("010405000002".getBytes("UTF-8")));
	        Object transactionAmount = Base64.getEncoder().encodeToString(cipher.doFinal("3".getBytes("UTF-8")));
	        Object IFSCCode = Base64.getEncoder().encodeToString(cipher.doFinal("IFSC001".getBytes("UTF-8")));
	        JSONObject json = new JSONObject();
	        json.put("customerReferenceNumber", customerReferenceNumber);
	        json.put("customerID", customerID);
	        json.put("debitAccountNumber", debitAccountNumber);
	        json.put("creditAccountNumber", creditAccountNumber);
	        json.put("transactionAmount", transactionAmount);
	        json.put("IFSCCode", IFSCCode);
	        return Utilities.createResponse(false, "", HttpStatus.OK, json);
	}
}

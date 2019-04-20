INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_PM');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO users(
            id, created, dob, email, gender, is_active, mobile_no, name, 
            password, updated, uuid)
    VALUES (1,current_timestamp,'1991-06-05 00:00:00','jenis.6591@gmail.com','MALE',TRUE,0000000000,'Jainish','test!213',current_timestamp,1234567890);

INSERT INTO userbank(
            id, bank_name, created, is_active, password, private_key, public_key, 
            updated, user_name)
    VALUES (2,'ICICI',current_timestamp,TRUE,'b6bc7b58510319a151d168ba3d5aecb3ac0a9708d06dd930f37fbc89b6cdc697','MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAI1INcAWKOZ9NV2CzpV9Z6vjv02PX7dxnt78Nd9GpYQqrnfBP5V7+BVLQMXzPGALSZlMaDJ47i9fsNI5mMpBKHY417GWLo74oJbGUTXA0XfrYIosCs+OFcw/Gj1etxMqTZjm1udxoyROAweCNzPhONqVrFtCbONgAQj3TgVSW5E7AgMBAAECgYBvd8iIvDMa3zDKjZjmUyIHeVI','MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCNSDXAFijmfTVdgs6VfWer479Nj1+3cZ7e/DXfRqWEKq53wT+Ve/gVS0DF8zxgC0mZTGgyeO4vX7DSOZjKQSh2ONexli6O+KCWxlE1wNF362CKLArPjhXMPxo9XrcTKk2Y5tbncaMkTgMHgjcz4TjalaxbQmzjYAEI904FUluROwIDAQAB',current_timestamp,'ICICIUAT');





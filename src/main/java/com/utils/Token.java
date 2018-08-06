package com.utils;


import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by paul on 2018/7/31
 * @author paul
 */
public class Token {
    /**
     * 发行者
     */
    public static final String ISSUSER="ssta";
    /**
     * 密令
     */
    public static final String SECRET="smartcityxfzh";

    /**
     * token有效期时长：8小时
     */
    public static final long OVERTIME=1000*60*60*8;

    //public static final long OVERTIME=1000*60;
    /**
     * * 创建token
     * @param subject 加密内容：用户信息、权限等
     * @return
     */
    public static String createToken(String subject){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);

            String token=JWT.create()
                    .withIssuer(ISSUSER)
                    .withSubject(subject)
                    .withExpiresAt(getTimeout())
                    .sign(algorithm);
            return token;
        } catch (UnsupportedEncodingException exception){
            //UTF-8 encoding not supported
            return "-1";
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            return "-1";
        }
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static String verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUSER)
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            String subject=jwt.getSubject();
            return subject;
        } catch (UnsupportedEncodingException exception){
            //UTF-8 encoding not supported
            return "-1";
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            return "-1";
        }
    }

    public static Date getTimeout(){
        long timeStamp = System.currentTimeMillis()+OVERTIME;
        Date timeout=new Date(Long.parseLong(String.valueOf(timeStamp)));
        return timeout;
    }

    public static Map getDataByTokenSubject(String subject){
        Map result=new HashMap(3);
        result.put("user",(Map) JSON.parseObject(subject).get("user"));
        return result;
    }

    public static Map getDataByTokenSubject2(String subject){
        Map result=new HashMap(3);
        result.put("user",(Map) JSON.parseObject(subject));
        return result;
    }

    public static void main(String[] args) {
        String token=Token.createToken("{\"user\":{\"userId\":\"436465476548\",\"userName\":\"paul\"}}");
        //System.out.println(token);
        //String subject= Token.verifyToken("eyj0exaioijkv1qilcjhbgcioijiuzi1nij9.eyjzdwiioij7xcj1c2vyxci6e1widxnlcl9pzfwiolwindrjmjvjmdy0mzy5ndi1m2fhmteyywrlztizymq5odnciixcimxvz2lux25hbwvcijpcijfciixcinvzzxjfbmftzvwiolwimlwilfwicgfzc3dvcmrcijpcimu5owexogm0mjhjyjm4zdvmmjywoduznjc4otiyztazxcisxcjwag9uzvwiolwimtmzmjm0ntk4nzzciixcimvtywlsxci6xci0xcisxcjyzw1hcmtcijpcijjciixcimnkyxrlxci6mtuwmdq0otmwotawmcxcimnwzxjzb25cijpcijfciixcinn0yxr1c1wiolwimfwilfwiaxnhzg1pblwiolwimfwilfwizmxhz1wiolwimfwilfwiyw55x2lkxci6xcjizdq0ywi4odq2nwm0zmewogu2ztg4yzbkyjrmotk5yvwifsxcim9yz1wiontcimvudgvychjpc2vfawrcijpcimjkndrhyjg4ndy1yzrmyta4ztzlodhjmgringy5otlhxcisxcjlbnrlcnbyaxnlx25hbwvcijpciua1i-ivlewnles9jvwilfwizgl2axnpb25fbmftzvwiolwi546v57-g5yy6xcisxcj3b3jrzxjzx2nvdw50xci6xcixmjnciixcimxvy2f0aw9ux25hbwvcijpciueor-e_oowmulwilfwizmlyzxbyb29mx3blcnnvblwiolwi5p-p5y2jxcisxcjmaxjlchjvb2zfcgvyc29ux2nhcmrcijpcijeym1wilfwizmlyzxbyb29mx3blcnnvbl9wag9uzvwiolwimtuyndy3odyynzbciixcimzpcmvwcm9vzl9wzxjzb25fzw1hawxcijpcimjhawh1aubyyxlzzgf0ys5jb21ciixcinrhylwiolwi5lia6iis5y2v5l2nxcisxcjsbmdcijpcijeymi4wodq0mtlciixcimxhdfwiolwimzcuntewnzu1xcisxcjzdgf0dxncijpcijbciixcimnwzxjzb25cijpcijfciixcimnkyxrlxci6mtq5otmwnje4ndawmcxcinr5cgvcijpciuwknuwfroalvfwilfwizw50zxjwcmlzzv9jb2rlxci6xcjjc2r3xcisxcjmaxjlx2p1cmlzzgljdglvblwiolwi546v57-g5yy65asn6zifxcisxcj1c2vfbmftzvwiolwi5rwl6k-v5y2v5l2nxcisxcjmaxjlx3jpc2tcijpciua1i-ivlewnles9jvwilfwiaxnfynvpbgrfbwfuywdlbwvudfwiolwi5zcmxcisxcjwyxjlbnrfb3jnxci6xclmtyvor5xljzxkvy1ciixcim9yz19jb2rlxci6xclmtyvor5xljzxkvy1ciixcinbvc3rjb2rlxci6xcixmjmxmjmxm1wilfwizw1hawxcijpcijeym0bxcs5jb21ciixcinbob25lxci6xcixmjnciixcimzhefwiolwimtizxcisxcjly29ub21py19vd25lcnnoaxbcijpcijeym1wilfwizm91bmrpbmdfdgltzvwioje0otkxodqwmdawmdasxcjjagfyz2vfbgv2zwxcijpcius6joe6p1wilfwibgvnywxfcgvyc29uxci6xcixmjmxmjnciixcimxlz2fsx3blcnnvbl9pzfwiolwimtizmtizxcisxcjszwdhbf9wzxjzb25fcghvbmvcijpcijeym1wilfwizml4zwrfyxnzzxrzxci6xcixmjnciixcimfyzwffy292zxjlzfwiolwimtizmvwilfwiyxjlyv9idwlszfwiolwimtizxcisxcjnzw9ncmfwahlcijpcijeym1wilfwiyxv0b19maxjlx2zhy1wiolwimtizxcisxcjhdhryawj1dgvfdhlwzvwiolwi6yen6kab56er56cu5y2v5l2nmlwilfwiywnjzxb0yw5jzv9zdgf0dxncijpciuw3sumqjoautlwilfwib3rozxjfaw5mb3jcijpciuayk-ehg-ayk-eihuwnsemzqewtgee7j-iqpewnles9jvwilfwizmlyzv9tyw5hz2vyx25hbwvcijpcijq1njq2xcisxcjmaxjlx21hbmfnzxjfawrcijpcijeym1wilfwizmlyzv9tyw5hz2vyx3bob25lxci6xci0nty0ntu2xcj9fsisimlzcyi6innzdgeilcjlehaioje1mdk5ntc5mdf9.gtd6kx_pieax29ijz_nhmfwuk-tede4ncvhfcqqigwk");
        token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ7XCJzeXNVc2VyRGVwdFwiOjAsXCJzeXNVc2VySWRcIjpcImM0YzBkMjRmLWM5MTMtNGVlZC04NWFlLWExMjFmZWJlNzI2ZVwiLFwic3lzVXNlck5hbWVcIjpcIlwiLFwic3lzVXNlclB3ZFwiOlwiXCIsXCJzeXNVc2VyVHlwZVwiOjB9IiwiaXNzIjoic3N0YSIsImV4cCI6MTUzMzA1MjQ3Mn0.ovTBFOp51T7hdEidQNEfUCmqd5M0ecL01qYU6sAxtaI";
        String subject= Token.verifyToken(token);
        System.out.println("==================="+ subject);

        Map map=getDataByTokenSubject(subject);
        System.out.println("==================="+ (JSON.parseObject(subject)));
    }
}

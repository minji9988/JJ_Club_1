package com.example.jj_club.network;

import com.example.jj_club.models.request.EmailConfirmationRequest;
import com.example.jj_club.models.response.EmailConfirmationResponse;
import com.example.jj_club.models.request.EmailVerificationRequest;
import com.example.jj_club.models.response.EmailVerificationResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* 변경 필요 사항
* @POST 애너테이션의 값은 실제 API 엔드포인트 경로로 대체해야 하며,
* @Field 애너테이션의 값은 요청에 필요한 필드 이름으로 변경되어야 합니다.
* */

// ApiService 파일에 대한 설명
// - 서버와 통신하기 위한 API 인터페이스 파일
// - 서버의 엔드포인트와 통신을 정의

public interface EmailVerificationInterface {

        @POST("/api/v1/auth/email")
        Call<EmailVerificationResponse> sendVerificationEmail( @Body EmailVerificationRequest request);

        @POST("/api/v1/auth/verifyCode")
        Call<EmailConfirmationResponse> verifyEmail( @Body EmailConfirmationRequest request);
}


//
//        @FormUrlEncoded
//        @POST("/api/v1/auth/email") // 이메일 인증을 처리하는 서버 API 엔드포인트
//        Call<Void> sendVerificationEmail(@Body String request); // 서버로 이메일 인증 요청을 보내는 역할,
//
//        @POST("complete-registration")
//        @FormUrlEncoded
//        Call<Void> completeRegistration(@Field("verificationCode") String verificationCode);
//
//        // verificationCode라는 필드를 가진 POST 요청을 보내는 역할을 함
//

/*각 메서드는 @POST 어노테이션을 통해 HTTP POST 요청을 수행하고,
필요한 매개변수를 @Field 어노테이션을 사용하여 전달합니다.
응답은 Call<Void> 타입으로 받습니다.*/


/*
## Call<Void> sendVerificationEmail(@Body EmailVerificationRequest request); 설명 ##

sendVerificationEmail 메서드는 서버로 이메일 인증 요청을 보내는 역할을 합니다.
이 때 @Body 어노테이션은 EmailVerificationRequest라는 객체를 전달한다는 의미입니다.
EmailVerificationRequest 객체는 이메일 인증에 필요한 데이터를 포함하고 있습니다.

이 객체는 사용자가 입력한 이메일 주소를 담고 있을 것입니다.
@Body 어노테이션을 사용함으로써 이 객체가 HTTP 요청의 본문에 포함되어 서버로 전송됩니다.

서버는 이메일 인증 요청을 받은 후 해당 이메일 주소로 인증 코드를 발송하게 될 것입니다.
따라서 sendVerificationEmail 메서드를 호출할 때,
EmailVerificationRequest 객체에는 사용자가 입력한 이메일 주소가 설정되어야 합니다.

간단히 말해, sendVerificationEmail 메서드는 이메일 인증 요청을 보내기 위해
사용자가 입력한 이메일 주소를 포함한 EmailVerificationRequest 객체를 서버로 전송한다는 의미입니다.


*/



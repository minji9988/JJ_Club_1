package com.example.jj_club;

// 보류 파일.
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Context;
import android.widget.Toast;

public class EmailVerificationManager {



}
//    private static final String BASE_URL = "https://your-api-endpoint.com/"; // 실제 API 엔드포인트 URL로 대체해야 함
//
//    private EmailVerificationService service;
//
//    private Context context; // Context 객체를 멤버 변수로 추가
//
//    public EmailVerificationManager(Context context) { //이메일 인증과 관련된 기능을 관리하는 클래스
//                                        // Retrofit을 사용하여 API와 통신하고, 이메일 인증 요청을 보내거나 회원가입을 완료하는 작업을 수행
//
//        this.context = context;
//        /* 아래 Retrofit 코드 설명
//        *
//        * 아래 코드는 Retrofit을 사용하여 API 서비스와 통신을 위한 Retrofit 인스턴스를 생성하고,
//        * 이를 통해 이메일 인증과 회원가입 완료 요청을 서버에 보낼 수 있는 기능을 구현하는데 사용됩
//        *
//        * */
//
//        Retrofit retrofit = new Retrofit.Builder() // Retrofit을 초기화하기 위해 Retrofit.Builder 객체를 생성
//                                                   // Builder 객체는 Retrofit 설정을 구성할 수 있는 메서드들을 제공
//                .baseUrl(BASE_URL)                 // Retrofit에 사용할 API의 기본 URL을 설정
//                                                   // BASE_URL은 실제 API 서버의 엔드포인트 주소로 대체되어야 함
//                .addConverterFactory(GsonConverterFactory.create())  // JSON 데이터를 자바 객체로 변환하기 위해 GsonConverterFactory를 추가
//                                                                     //이렇게 하면 Retrofit은 서버 응답의 JSON 데이터를 자동으로 파싱하여 자바 객체로 변환할 수 있음
//                .build(); //이전 단계에서 구성한 설정으로 Retrofit 객체를 빌드
//                          //최종적으로 사용할 Retrofit 인스턴스를 생성
//
//        service = retrofit.create(EmailVerificationService.class); //Retrofit 인스턴스를 사용하여 API 서비스의 구현체를 생성
//        // EmailVerificationService.class는 Retrofit이 생성할 API 서비스의 인터페이스임
//        // 이 인터페이스는 API 요청 메서드들을 선언하고, Retrofit은 이를 구현하여 서버와의 통신을 처리함
//    }
//
//// sendVerificationEmail 메서드 설명
///* - 인자로 이메일을 받아 이메일 인증 요청을 보내는 메서드.
//   - 이메일 도메인이 "@jj.ac.kr"로 끝날 때만 인증 요청을 수행하며,
//   - 요청의 성공 또는 실패에 따라 적절한 처리를 수행함.*/
//// - sendVerificationEmail  메서드를 호출하여 사용자가 입력한 이메일을 서버로 전송하고 응답을 처리
//    public void sendVerificationEmail(String email) {
//        if (email.endsWith("@jj.ac.kr")) {
//            Call<Void> call = service.sendVerificationEmail(email);
////            Call<Void> call = service.sendVerificationEmail(email); //Call 객체는 웹 서버에 요청을 보낼 때 사용하는 객체
//                                                                    /*service.sendVerificationEmail(email)은
//                                                                    EmailVerificationService 인터페이스의 sendVerificationEmail 메서드를 호출하여 이메일 인증 요청을 보내는 것*/
//            call.enqueue(new Callback<Void>() { // call: 서버로  HTTP 요청을 나타내는 객체, enqueue: 메서드를 호출하여 해당 요청을 처리하도록 합
//                @Override
//                public void onResponse(Call<Void> call, Response<Void> response) {
//                    if (response.isSuccessful()) {
//                        Toast.makeText(context, "인증 코드가 전송되었습니다.", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(context, "인증 코드 발송에 실패했습니다.", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<Void> call, Throwable t) {
//                    // 네트워크 오류 등으로 인해 이메일 인증 요청 실패
//                    // 오류 처리를 수행할 수 있음
//                    Toast.makeText(context, "네트워크 오류로 인해 이메일 인증 코드 발송에 실패했습니다.", Toast.LENGTH_SHORT).show();
////                    Log.e("EmailVerification", "이메일 인증 요청 실패: " + t.getMessage());
//                }
//            });
//        } else {
//            // 인증할 수 없는 이메일 도메인 처리
//            Toast.makeText(context, "전주대 이메일(@jj.ac.kr)로만 가입이 가능합니다", Toast.LENGTH_SHORT).show();
//            //Log.d("EmailVerification", "인증할 수 없는 이메일 도메인입니다.");
//        }
//    }
//
//
//    // completeRegistration 메서드 설명
//    // - 인자로 (이메일) 인증 코드를 받아 회원가입 완료 요청을 보냄.
//    // - 요청의 성공 또는 실패에 따라 적절한 처리를 수행합니다.
//    public void completeRegistration (String code) {
//
//        Call<Void> call = service.completeRegistration(code);
////        Call<Void> call = service.completeRegistration(verificationCode);
//        call.enqueue(new Callback<Void>() {
//
//            // onResponse 메서드에서 서버 응답이 성공인 경우와 실패인 경우에 대해 처리
//            @Override
//            public void onResponse(Call<Void> call, Response<Void> response) {
//                if (response.isSuccessful()) {
//                    // 이메일 인증 성공
//                    Toast.makeText(context, "이메일 인증이 완료되었습니다.", Toast.LENGTH_SHORT).show();
//                } else {
//                    // 이메일 인증 실패
//                    Toast.makeText(context, "이메일 인증에 실패했습니다.", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Void> call, Throwable t) {
//                // 네트워크 오류 등으로 인해 회원가입 완료 요청 실패
//                Toast.makeText(context, "회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}


/*

콜백(callback)은 프로그래밍에서 한 기능의 실행이 완료되면 호출되는 함수입니다.
즉, 특정 작업이 끝나면 시스템 또는 다른 코드에게 알리기 위해 사용됩니다.

코드에서 call.enqueue(new Callback<Void>() { ... }) 부분을 더 자세히 설명하자면 다음과 같습니다.

call은 Retrofit을 통해 서버로 보내는 HTTP 요청을 나타내는 객체입니다.
sendVerificationEmail 메서드에서 서버로 이메일 인증 요청을 보내기 위해 사용됩니다.

enqueue는 Retrofit에서 제공하는 비동기적인 요청 실행 메서드입니다.
이 메서드는 요청을 백그라운드에서 비동기적으로 실행하고,
요청의 결과를 받을 때까지 기다리지 않고 다음 코드를 실행합니다.

new Callback<Void>() { ... }는 익명 클래스(anonymous class)를 생성하고 있습니다.
이 클래스는 콜백 인터페이스를 구현한 객체입니다. 여기서는 Callback<Void> 인터페이스를 구현한 콜백 객체를 생성하고 있습니다.

중괄호 { ... } 안에는 콜백에서 처리할 동작을 정의합니다.
onResponse 메서드는 요청에 대한 응답이 성공적으로 도착했을 때 호출되며, onFailure 메서드는 요청에 실패했을 때 호출됩니다.

onResponse: 서버로부터의 응답을 처리하는 부분입니다. 이 메서드는 요청이 성공적으로 완료되었을 때 호출됩니다. 응답을 확인하고 필요한 작업을 수행할 수 있습니다.
onFailure: 요청이 실패했을 때 호출되는 부분입니다. 네트워크 오류 또는 서버 오류 등의 이유로 요청이 실패한 경우에 이 메서드가 호출됩니다. 실패에 대한 예외 처리나 오류 메시지 출력 등을 수행할 수 있습니다.
이렇게 콜백을 사용하면 서버로부터의 응답을 비동기적으로 처리할 수 있습니다. 요청을 보낸 후에는 응답이 도착할 때까지 다른 작업을 수행할 수 있으며, 응답이 도착하면 정의한 동작을 수행하여 적절히 처리할 수 있습니다.


우리가 가끔 다른 사람에게 도움을 요청하고 그 결과를 받는 상황을 생각해보세요.
 예를 들어, 당신이 슈퍼마켓에 갔을 때 특정 상품을 찾을 수 없다면,
 당신은 직원에게 도움을 요청하고 기다리게 될 것입니다. 그리고 직원은 찾아야 하는 상품을 찾은 후에 당신에게 알려줄 겁니다.

이때 직원은 콜백 역할을 합니다.
당신이 도움을 요청하는 시점에는 직원은 다른 일을 하고 있을 수도 있습니다.
그러나 당신이 요청을 보내면서 당신이 원하는 동작(상품을 찾는 것)을 알려주면, 직원은 그 동작을 완료한 후에 당신에게 결과를 알려줍니다.

코드에서 call.enqueue(new Callback<Void>() { ... }) 부분은 이 상황을 구현한 것입니다.
call은 요청을 보내는 객체이고, enqueue 메서드를 호출하여 해당 요청을 처리하도록 합니다. 그리고 { ... } 안에는 요청이 성공했을 때와 실패했을 때의 동작을 정의하게 됩니다.*/




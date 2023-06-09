package com.example.jj_club.network;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
======Retrfit API 파일(ApiService)과 Retrofit Client 파일의 차이========
- Retrofit API 인터페이스 파일은 서버의 엔드포인트와 통신을 정의하고,
- 클라이언트 파일은 Retrofit을 초기화하고 설정하여 실제 통신을 수행합니다.
*/

///////해당 파일은 수정 필요 ##

public class RetrofitClient {
    private static final String BASE_URL = "http://Cap.jjclub.pe.kr:80/"; // 실제 API의 기본 URL로 변경해야 합니다.


    private static Retrofit retrofit; //Retrofit 인스턴스를 저장하는 정적 변수

    public RetrofitClient() {
//        private으로 선언되어 있어 외부에서의 인스턴스 생성을 막음
//        외부에서 인스턴스를 직접 생성하지 못하도록 제한하기 위해 작성.
    }

    public static Retrofit getClient() { //Retrofit 인스턴스를 반환하는 메서드
        if (retrofit == null) { //인스턴스 여러 번 생서하는 것을 방지하기 위해, 인스턴스가 없는 경우(null)에만 인스턴스 생성
            retrofit = new Retrofit.Builder() //Retrofit.Builder를 사용하여 Retrofit 인스턴스를 생성
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}



// ======================================================================

/* RetroficClient 파일에 대한 설명(읽을 필요없음)
RetrofitClient.java 파일은 Retrofit 라이브러리를 사용하여 서버와의 통신을 위한
클라이언트 인스턴스를 생성하고 설정하는 역할을 담당하는 클래스입니다.

Retrofit은 RESTful API와의 통신을 쉽게 처리할 수 있도록 도와주는 라이브러리입니다.
이 라이브러리를 사용하기 위해서는 Retrofit 인스턴스를 생성하고,
해당 인스턴스를 통해 API 인터페이스와의 연결을 설정해야 합니다.
이러한 설정은 보통 RetrofitClient 클래스에서 이루어집니다.

RetrofitClient 클래스에는 다음과 같은 주요 역할이 포함될 수 있습니다.

- Retrofit 인스턴스 생성: Retrofit.Builder를 사용하여 Retrofit 인스턴스를 생성합니다.
이때, 서버의 기본 URL과 Gson 컨버터 등의 설정을 지정할 수 있습니다.

- API 인터페이스와의 연결: Retrofit 인스턴스를 사용하여 API 인터페이스와의 연결을 설정합니다.
API 인터페이스는 서버의 엔드포인트와 통신하기 위한 메서드들을 정의하는 역할을 합니다.


RetrofitClient 클래스를 별도로 작성하는 이유는 코드의 모듈화와 재사용성을 높이기 위해서입니다.
Retrofit 설정과 관련된 로직을 한 곳에 모아두면 다른 곳에서도 쉽게 재사용할 수 있고, 코드의 가독성과 유지보수성도 향상됩니다.

따라서 RetrofitClient.java 파일을 작성하여 Retrofit 인스턴스 생성과 API 인터페이스와의 연결을 설정하는 역할을 할 수 있도록 하는 것이 일반적인 구현 방식입니다.
*
* */

// ======================================================================

/*

Retrofit 인스턴스를 생성하는 이유


- 인스턴스란?

인스턴스는 클래스의 객체를 생성하는 과정을 말합니다. 클래스는 객체의 설계도이며,
인스턴스는 그 설계도를 바탕으로 실제로 메모리에 할당된 객체를 의미합니다.

클래스를 사용하여 인스턴스를 생성하는 이유는 해당 클래스의 속성과 메서드를 사용할 수 있도록 하기 위함입니다.
즉, 인스턴스를 생성함으로써 해당 클래스에 정의된 필드(속성)와 메서드를 활용하여 원하는 작업을 수행할 수 있게 됩니다.


- Retrofit에서 인스턴스를 사용하는 이유

 Retrofit 인스턴스를 생성하는 이유는 Retrofit 라이브러리를 사용하여 서버와의 통신을 수행하기 위해서입니다.
 Retrofit은 RESTful API와의 통신을 쉽게 처리하기 위한 도구로 사용되며,
 인스턴스를 생성하여 해당 인스턴스를 통해 API와의 통신을 설정하고 요청을 보낼 수 있습니다.


*/


/*

# Singleton 패턴을 사용하는 이유

Retrofit 인스턴스를 여러 번 생성하는 것은 비효율적입니다.
네트워크 연결을 설정하고 컨버터를 추가하는 등의 초기화 작업은 한 번만 수행하면 되기 때문이다.
여러 곳에서 Retrofit 인스턴스를 사용해야 할 때, 동일한 인스턴스를 공유함으로써 일관된 설정과 상태를 유지할 수 있습니다.


# Singleton 패턴이란?
Singleton 패턴은 객체 지향 프로그래밍에서 사용되는 디자인 패턴 중 하나로,
특정 클래스의 인스턴스를 오직 하나만 생성하고 전역적으로 접근할 수 있게 하는 방법입니다.


싱글톤은 "오직 한 개의 아이스크림 가게"와 비슷합니다.
이 가게에는 항상 동일한 아이스크림 가게 주인이 있고, 모든 사람들은 이 가게에서 아이스크림을 구매합니다.

싱글톤 패턴의 특징은 다음과 같습니다:

- 한 개의 인스턴스: 아이스크림 가게는 오직 한 개만 존재합니다. 여러 개의 가게가 생기지 않고 항상 같은 가게에 접근합니다.

- 전역적인 접근: 아이스크림을 사려면 어디서든 해당 아이스크림 가게에 접근할 수 있습니다.
가게가 하나뿐이므로 모든 사람이 동일한 가게에 접근하여 아이스크림을 구매합니다.

# 싱글톤 패턴은 어떻게 구현할 수 있을까요?

- 생성자 제한: 아이스크림 가게 주인은 외부에서 직접 가게를 만들지 못하도록 합니다. 가게 주인에게만 가게를 만드는 권한이 있습니다.
- 정적 변수: 아이스크림 가게 주인은 가게를 하나만 가지고 있습니다. 이 가게는 정적 변수로 선언되어 어디서든 접근할 수 있습니다.
- 접근 메서드: 사람들은 아이스크림을 사기 위해 해당 가게에 접근하는 메서드를 호출합니다. 이 메서드는 항상 같은 가게를 반환합니다.

이와 같이 싱글톤 패턴을 사용하면 어디서든 동일한 인스턴스에 접근할 수 있고,
인스턴스를 여러 번 생성하는 것을 방지할 수 있습니다.
싱글톤 패턴은 유용한 패턴 중 하나이며, 전역적인 리소스를 관리하거나 공유해야 하는 상황에서 활용됩니다.

*/


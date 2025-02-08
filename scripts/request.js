import http from 'k6/http';
import { sleep, check } from 'k6';

export let options = {
  vus: 1000,
  //vus: 1000,           // 가상 사용자(Virtual Users) 수
  duration: '40s',   // 테스트 지속 시간
};

let id = 1;
export default function () {
  // 테스트할 API URL
  const url = 'http://localhost:8080/api/videos'

  // POST 요청으로 전송할 데이터 (필요에 따라 수정)
  const payload = JSON.stringify({
    userId: __VU,
  });

  // 요청 헤더 (Content-Type: application/json)
  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  // POST 요청 실행
  let response = http.post(url, payload, params);

  // 응답 상태 코드가 200인지 체크
  check(response, {
    '응답 상태 코드가 200인가?': (r) => r.status === 200,
  });

  // 1초 대기 (사용자 간의 요청 간격 조정)
  sleep(1);
}


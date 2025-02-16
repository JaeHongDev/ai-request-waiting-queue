import http from 'k6/http';
import { check, sleep } from 'k6';

export let options = {
  vus: 1000, // 가상 유저 수
  duration: '10s', // 테스트 실행 시간
};

export default function () {
  const url = 'http://localhost:8080/api/videos';
  const payload = JSON.stringify({
  });

  const params = {
    headers: {
      'Content-Type': 'application/json',
    },
  };

  let res = http.post(url, payload, params);

  check(res, {
    'status is 200': (r) => r.status === 200,
  });

  sleep(1); // 다음 요청 전 1초 대기
}


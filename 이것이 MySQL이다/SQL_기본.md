# SQL 기본

## 1. SELECT문

### 1) 원하는 데이터를 가져와 주는 기본적인 <SELECT ... FROM>
- `Duration` : SQL문이 실행되는데 걸린 시간
- `Fetch` : 실제 데이터를 가져오는데 걸린 시간
```sql
-- 데이터베이스 테이블 정보 조회
SHOW TABLE STATUS;
```

<br>

```sql
-- 테이블 상세 정보 조회
DESCRIBE employees;
DESC employees;
```

<br>

- 데이터베이스 개체의 이름 규칙
  1. `a-z`, `A-Z`, `0-9`, `$`, `_`를 사용할 수 있다
  - 기본 설정은 영문 대문자나 소문자로 입력해도 소문자로 생성
  2. 개체 이름은 최대 64자로 제한
  3. 예약어를 사용하면 안된다
  4. 개체 이름은 원칙적으로 공백이 있으면 안되나, `백틱`을 사용하여 생성 가능

### 2) 특정한 조건의 데이터만 조회하는 <SELECT ... FROM ... WHERE>
- `AND` -> `BETWEEN`
- `OR` -> `IN`
- `LIKE` : 문자열 검색
- `ANY` : 서브 쿼리의 결과 중 한가지만 만족해도 가능
- `ALL` : 서브 쿼리의 결과를 모두 만족해야 가능
- `ORDER BY` : 기본적으로 오름차순 정렬
- `DISTINCT` : 중복된 것은 한개만 남도록
- `LIMIT` : 출력 개수를 제한
- `CREATE TABLE ... SELECT` : 테이블을 복사할 때 사용
  - PK나 FK 등 제약조건은 복사되지 않는다

### 3) GROUP BY 및 HAVING 그리고 집계 함수
- `SUM`
- `AVG`
- `MIN`
- `MAX`
- `COUNT`
- `STDEV` : 표준편차
- `VAR_SAMP` : 분산
- `HAVING` : 집계 함수에 대한 조건, 반드시 GROUP BY 다음에 존재
- `WITH ROLLUP` : 중간 합계를 알고 싶을 때 사용

### 4) SQL의 분류
- `DML` (Data Manipulation Language)
  - 데이터를 조작(선택, 삽입, 삭제, 수정)하는데 사용되는 언어
  - SELECT, INSERT, DELETE, UPDATE
- `DDL` (Data Definition Language)
  - 데이터베이스, 테이블, 뷰, 인덱스 등 데이터베이스 개체를 생성, 삭제, 변경하는 역할
  - CREATE, DROP, ALTER
- `DCL` (Data Control Language)
  - 사용자에게 권한을 주거나 빼앗을 때 사용
  - GRANT, REVOKE, DENY

<br>

## 2. 데이터의 변경을 위한 SQL문

### 1) 데이터의 삽입 : INSERT
- AUTO_INCREMENT
  - 꼭 `PRIMARY KEY`나 `UNIQUE` 설정이 필요
  - 증가값을 변경하려면 서버 변수인 `@@AUTO_INCREMENT_INCREMENT` 변경
- INSERT INTO ... SELECT
  - 대량의 데이터 삽입

### 2) 데이터의 수정 : UPDATE
- WHERE 절을 생략하면 테이블 전체 데이터가 수정

### 3) 데이터의 삭제 : DELETE FROM
- WHERE 절을 생략하면 테이블 전체 데이터가 삭제
- `TRUNCATE`, `DROP`
- `DELETE`가 가장 느리다
  - DML로 트랙잭션이 존재하고 트랙잭션 로그를 기록하는 작업이 추가적으로 진행되기 때문에 가장 느리다
  - 따라서 테이블을 살리고 데이터 전체 삭제에는 `TRUNCATE`, 테이블까지 삭제는 `DROP`을 사용

### 4) 조건부 데이터 입력, 변경
```sql
-- 중간에 오류가 발생하면 기존에는 아래 SQL문이 실행되지 않지만 무시하고 넘어감
INSERT IGNORE INTO memberTBL VALUES('BBK', '비비코', '미국');
...
...
```

<br>

```sql
-- 중복되는 Key가 존재하면 데이터 삽입이 아닌 업데이트를 진행
INSERT INTO memberTBL VALUES('BBk', '비비코', '미국')
    ON DUPLICATE KEY UPDATE name='비비코', addr='미국';
```

<br>

## 3. WITH절과 CTE

### 1) WITH절과 CTE 개요
- `CTE` (Common Table Expression)
- 비재귀적 CTE, 재귀적 CTE 존재

### 2) 비재귀적 CTE
```sql
-- 구문을 단순하게 해주는 효과
WITH CTE_테이블이름(열 이름)
AS
(
    ...
);
SELECT * FROM CTE_테이블이름;
```
- CTE는 뷰와 그 용도는 비슷하지만 개선된 점이 많이 존재
- 뷰는 계속해서 존재하여 다른 구문에도 사용할 수 있지만 CTE와 파생 테이블은 구문이 끝나면 같이 소멸
- 아직 정의되지 않은 CTE를 미리 참조할 수 없다
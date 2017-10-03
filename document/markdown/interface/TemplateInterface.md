# Template API

## 詳細

ここに詳細を書く  
ここに詳細を書く

## メソッド

#### [GET /api/template/:username](#POST_apiTemplateId)  
`ひとことコメントを記載`  
#### [POST /api/template/:id](#POST_apiTemplateId)  
`(例)テンプレートを登録する`  

### 変数

* :username ユーザ名
* :id ユーザID

## リクエストパラメータ

### *POST /api/template/:username*

ユーザ名を元にユーザを検索し、ユーザを返却する。

| Parameters | Descripion | Required | class |
|:--|:--|:--|:--|
| id | ユーザID<br>DBで登録された時のIDを記載する。<br>ユーザはこの値を知らない。 | yes | int |
| username | ユーザ名 | yes | String(min=1, max=20) |
| password | パスワード | yes | String(min=1, max=20) |
| mail | メールアドレス | yes | String(min=1, max=20) |

#### Sample Request

```
POST /api/template/test1
```

#### Sample Response

```
POST /api/template/test1  
{  
  id:1,  
  username:"test1",  
  password:"password",  
  mail:"test1@test"  
}  
```


### *POST /api/template/:id* <a name="POST_apiTemplateId">

ここに適宜説明を記載  
ここに適宜説明を記載  

| Parameters | Descripion | Required | class |
|:--|:--|:--|:--|
| id | ユーザID | yes | int |
| username | ユーザ名 | yes | String(min=1, max=20) |
| password | パスワード | yes | String(min=1, max=20) |
| mail | メールアドレス | yes | String(min=1, max=20) |

#### Sample Request

```
POST /api/template/test1  
{  
  id:1,  
  username:"test1",  
  password:"password",  
  mail:"test1@test"  
}  
```

#### Sample Response

```
POST /api/template/test1  
{  
  id:1,  
  username:"test1",  
  password:"password",  
  mail:"test1@test"  
}  
```

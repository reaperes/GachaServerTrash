# GachaServer
## Run
./gradlew bootRun

## APIs
| URL          | Method | Description                       |
|:------------ |:------:| --------------------------------- |
| /restaurants | GET    |                                   |
| /restaurants | POST   | save restaurant data              |

{
	"latitude": number,
	"longitude": number,
	"name": string,
	"score": number (0~100)
}
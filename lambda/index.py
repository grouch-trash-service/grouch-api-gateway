import json
def handler(event, context):
    return {
        "statusCode": 200,
        "headers": {'Access-Control-Allow-Origin': '*'},
        "body": json.dumps({
            "message": "Hello. Trash pickup will be on Tuesday... Now SCRAM!",
        }),
    }
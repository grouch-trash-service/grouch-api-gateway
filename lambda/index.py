import json
def handler(event, context):
    return {
        "statusCode": 200,
        "body": json.dumps({
            "message": "Hello. Trash pickup will be on Tuesday... Now SCRAM!",
        }),
    }
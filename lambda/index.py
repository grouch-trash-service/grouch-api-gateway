import boto3


def handler(event, context):
    """Delegates lambda call to aws"""
    lambda_client = boto3.client('lambda')
    response = lambda_client.invoke(FunctionName='GrouchMessageFunction')
    return response['Payload']._raw_stream.data
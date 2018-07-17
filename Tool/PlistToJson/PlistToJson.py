import os

from biplist import *
import json

import sys

reload(sys)
sys.setdefaultencoding('utf-8')


def ReadPlistToString(path):
    try:
        plist = readPlist(path)
        return plist
    except (InvalidPlistException, NotBinaryPlistException), e:
        print "Not a plist:", e


def WriteStringToJson(path, content):
    json_str = json.dumps(content, encoding='utf-8', ensure_ascii=False)
    file_object = open(path, 'w')
    file_object.writelines(json_str)
    file_object.close()


if __name__ == "__main__":
    PlistPath = sys.argv[1]
    JsonPath = sys.argv[2]
    Content=""
    try:
        Content = ReadPlistToString(PlistPath)
    except IOError:
        print('Please Input Current .Plist path')
        os._exit(0)

    try:
        WriteStringToJson(JsonPath, Content)
    except IOError:
        print('Please Input Current .Json path')
        os._exit(0)



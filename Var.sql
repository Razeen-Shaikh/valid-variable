-- Create database var;

DROP TABLE IF EXISTS Keywords;

CREATE TABLE Keywords (words varchar(255));

LOCK TABLES Keywords WRITE;

INSERT INTO Keywords VALUES ('int'),('char'),('float'),('double'),('abstract'),('assert'),('boolean'),('break'),('byte'),('case'),('catch'),('class'),('continue'),('const'),('default'),('do'),('else'),('enum'),('exports'),('extends'),('final'),('for'),('goto'),('if'),('implements'),('import'),('instanceof'),('interface'),('long'),('module'),('native'),('new'),('package'),('private'),('protected'),('public'),('requires'),('return'),('short'),('static'),('strictfp'),('super'),('switch'),('synchronized'),('this'),('throw'),('throws'),('transient'),('try'),('var'),('void'),('volatile'),('while'),('true'),('false'),('null');

UNLOCK TABLES;
#!/usr/bin/env python
from random import *
import time
import sys

timeout=0
while True:
	print randint(0,100)
	sys.stdout.flush()
	time.sleep(0.5)


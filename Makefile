.PHONY: all stable test

all:
	lein lambda deploy dev

stable:
	lein lambda deploy stable

test:
	lein test

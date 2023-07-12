#!/bin/sh
mvn test -D xmlFile=all-orders.xml -D browser=edge
mvn test -D xmlFile=all-orders.xml -D browser=chrome
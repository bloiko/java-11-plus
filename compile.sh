#!/usr/bin/env bash
javac -d ./mods/  --module-source-path src $(find src -name "*.java")

#!/usr/bin/env bash
function rmIfExist {
    DIR=$1
    if [ -d "$DIR" ]; then
        printf '%s\n' "Removing $DIR"
        rm -rf "$DIR"
    fi
}

rmIfExist build
rmIfExist mods

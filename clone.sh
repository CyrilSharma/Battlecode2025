#!/bin/bash

# Hardcoded source directory and base path for new directory
SOURCE_DIR="java/src/current"
BASE_PATH="java/src"

# Check if SOURCE_DIR exists
if [[ ! -d "$SOURCE_DIR" ]]; then
  echo "Source directory '$SOURCE_DIR' does not exist. Exiting."
  exit 1
fi

# Check for required argument
if [[ $# -ne 1 ]]; then
  echo "Usage: $0 <new_directory_name>"
  exit 1
fi

# Read arguments
NEW_DIR_NAME="$1"
NEW_DIR="$BASE_PATH/$NEW_DIR_NAME"

# Create the new directory
if [[ -d "$NEW_DIR" ]]; then
  echo "Directory '$NEW_DIR' already exists. Exiting."
  exit 1
fi

mkdir -p "$NEW_DIR"
cp -r "$SOURCE_DIR/"* "$NEW_DIR"

# Generate the new package name from the new directory name
NEW_PACKAGE="${NEW_DIR_NAME//\//.}"

# Update package statements in all Java files
find "$NEW_DIR" -type f -name "*.java" | while read -r file; do
  sed -i '' -e "s/^package .*;/package $NEW_PACKAGE;/" "$file"
done

echo "Directory '$NEW_DIR' created with updated package statements to '$NEW_PACKAGE'."

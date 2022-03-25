echo "Processing..."

set -e
export DB_NAME="testdb"
export POSTGRES_URL="jdbc:postgresql://localhost:5432/${DB_NAME}"
export POSTGRES_USER="postgres"
export POSTGRES_PASS="password"
set +e

echo "Done!"

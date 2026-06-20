"""Generate sample_<N>.csv for each exm1 model.

Reads all per-project CSVs under <model>/z_final/, randomly samples N rows with
a fixed seed, and writes them to <model>/sample_<N>.csv keeping only the
columns model, project, bug_id, variant, status.
"""
import csv
import random
from pathlib import Path

ROOT = Path(__file__).parent

COLUMNS = ["model", "project", "bug_id", "variant", "status"]


def collect_rows(model_dir: Path):
    rows = []
    for fp in sorted((model_dir / "z_final").glob("*.csv")):
        if fp.name.startswith("sample_"):
            continue
        with fp.open(newline="") as f:
            for row in csv.DictReader(f):
                rows.append({k: row.get(k, "") for k in COLUMNS})
    return rows


def write_sample(model: str, n: int, seed: int = 42):
    model_dir = ROOT / model
    rows = collect_rows(model_dir)
    if n > len(rows):
        raise SystemExit(f"{model}: requested {n} rows but only {len(rows)} available")
    sampled = random.Random(seed).sample(rows, n)
    sampled.sort(key=lambda r: (r["project"], int(r["bug_id"]) if r["bug_id"].isdigit() else r["bug_id"], r["variant"]))

    out_path = model_dir / f"sample_{n}.csv"
    with out_path.open("w", newline="") as f:
        writer = csv.writer(f)
        writer.writerow(COLUMNS)
        for r in sampled:
            writer.writerow([r[c] for c in COLUMNS])
    print(f"  wrote {out_path}  ({n} rows from {len(rows)} total)")


if __name__ == "__main__":
    write_sample("Claude", 94)
    write_sample("DeepSeek", 94)
    write_sample("GPT5", 94)

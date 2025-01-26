
/**
 Function receives an array of string with length N, and each value with M chars.
 '.' denotes space, '#' a ship in the string
 It is in the format:
 [
 .#..#.
 .#..#.
 #..##.
 ]
 A single ship part is patrol, a double ship part is submarine, 3 joined parts are destroyers.0
 
 Function countShips counts and returns an array consisting of quantity of [patrols, submarines, destroyers]
 */
function countShips(B: string[]): number[] {
    const N = B.length;
    const M = B[0].length;
    const patrolsQuantity = countPatrols(B, N, M);
    const submarinesQuantity = countSubmarines(B, N, M);
    const destroyersQuantity = countDestroyers(B, N, M);

    return new Array(patrolsQuantity, submarinesQuantity, destroyersQuantity)
}

function countPatrols(B: string[], N: number, M: number): number {
    let patrolsQuantity = 0;

    let indexN = 0;
    let indexM = 0;
    while (indexN < N) {
        while (indexM < M) {
            if (isShip(B, indexN, indexM) && areSidesEmpty(B, N, M, indexN, indexM)) {
                patrolsQuantity++;
            }
            indexM++;
        }
        indexN++;
    }
    return patrolsQuantity;
}

function countSubmarines(B: string[], N: number, M: number): number {
    let submarinesQuantity = 0;

    let indexN = 0;
    while (indexN < N) {
        let indexM = 0;
        while (indexM < M) {
            if (isShip(B, indexN, indexM) && !isUpShip(B, indexN, indexM)) {
                if (isRightShip(B, M, indexN, indexM)) {
                    if (!isDownShip(B, N, indexN, indexM) && !isUpShip(B, indexN, indexM + 1) && !isRightShip(B, M, indexN, indexM + 1)
                        && !isDownShip(B, N, indexN, indexM + 1)) {
                        submarinesQuantity++;
                        indexM += 2;
                    }
                } else if (isDownShip(B, N, indexN, indexM) && !isRightShip(B, M, indexN, indexM) && !isRightShip(B, M, indexN + 1, indexM) && !isDownShip(B, N, indexN + 1, indexM) && !isLeftShip(B, indexN + 1, indexM)) {
                    submarinesQuantity++;
                    indexM += 1;
                }
            }
            indexM++;
        }
        indexN++;
    }
    return submarinesQuantity;
}

function countDestroyers(B: string[], N: number, M: number): number {
    let destroyersQuantity = 0;

    let indexN = 0;
    while (indexN < N) {
        let indexM = 0;
        while (indexM < M) {
            if (isShip(B, indexN, indexM) && !isUpShip(B, indexN, indexM)) {
                if (isRightShip(B, M, indexN, indexM)) {
                    if (!isDownShip(B, N, indexN, indexM)) {
                        // check cases with no down ship
                        if (!isUpShip(B, indexN, indexM + 1) && isRightShip(B, M, indexN, indexM + 1) && !isDownShip(B, N, indexN, indexM + 1)
                            && !isUpShip(B, indexN, indexM + 2) && !isRightShip(B, M, indexN, indexM + 2) && !isDownShip(B, N, indexN, indexM + 2)) {
                            // 1st pic (horizontal)
                            destroyersQuantity++;
                            indexM += 3; // increment 3 as already 3 on the right checked
                        } else if (isDownShip(B, N, indexN, indexM + 1)
                            && !isUpShip(B, indexN, indexM + 1) && !isRightShip(B, M, indexN, indexM + 1)
                            && !isRightShip(B, M, indexN + 1, indexM + 1) && !isDownShip(B, N, indexN + 1, indexM + 1) && !isLeftShip(B, indexN + 1, indexM + 1)) {
                            // 4th destroyer in pic 
                            destroyersQuantity++;
                            indexM += 2; //increment 2 as already 2 on the right checked
                        }
                    } else { // cases with ship down
                        if (isDownShip(B, N, indexN, indexM)
                            && !isUpShip(B, indexN, indexM + 1) && !isRightShip(B, M, indexN, indexM + 1) && !isDownShip(B, N, indexN, indexM + 1)
                            && !isRightShip(B, M, indexN + 1, indexM) && !isDownShip(B, N, indexN + 1, indexM) && !isLeftShip(B, indexN + 1, indexM)) {
                            // 3rd destroyer in pic 
                            destroyersQuantity++;
                            indexM += 2; // increment 2 as already 2 on the right checked
                        } else if (!isLeftShip(B, indexN, indexM) && isLeftShip(B, indexN + 1, indexM)
                            && !isRightShip(B, M, indexN, indexM + 1)
                            && !isRightShip(B, M, indexN + 1, indexM) && !isDownShip(B, N, indexN + 1, indexM)
                            && !isDownShip(B, N, indexN + 1, indexM - 1) && !isLeftShip(B, indexN + 1, indexM - 1)) {
                            // 6th destroyer in pic 
                            destroyersQuantity++;
                            indexM += 1; // increment 1 as already 1 on the right checked
                        }
                    }
                } else if (isDownShip(B, N, indexN + 1, indexM)
                    && !isRightShip(B, M, indexN + 1, indexM) && !isDownShip(B, N, indexN + 1, indexM) && !isLeftShip(B, indexN + 1, indexM)
                    && !isRightShip(B, M, indexN + 2, indexM) && !isDownShip(B, N, indexN + 2, indexM) && !isLeftShip(B, indexN + 2, indexM)) {
                    // 2nd pic (vertical)
                    destroyersQuantity++;
                    indexM += 1;
                } else if (isDownShip(B, N, indexN, indexM) && isRightShip(B, M, indexN + 1, indexM)
                    && !isDownShip(B, N, indexN + 1, indexM) && !isLeftShip(B, indexN + 1, indexM)
                    && !isRightShip(B, M, indexN, indexM + 1) && !isDownShip(B, N, indexN, indexM + 1)) {
                    // 5th destroyer in pic 
                    destroyersQuantity++;
                    indexM += 1; // increment 1 as already 1 on the right checked
                }
            }
            indexM++;
        }
        indexN++;
    }
    return destroyersQuantity;
}

function isShip(B: string[], indexN: number, indexM: number): boolean {
    return B[indexN].charAt(indexM) == '#'
}

function areSidesEmpty(B: string[], N: number, M: number, indexN: number, indexM: number): boolean {
    return !(isLeftShip(B, indexN, indexM) || isRightShip(B, M, indexN, indexM)
        || isUpShip(B, indexN, indexM) || isDownShip(B, N, indexN, indexM))
}

function isLeftShip(B: string[], indexN: number, indexM: number): boolean {
    if (indexM - 1 > 0 && B[indexN].charAt(indexM - 1) == '#')
        return true;

    return false;
}

function isRightShip(B: string[], M: number, indexN: number, indexM: number): boolean {
    if (indexM + 1 < M && B[indexN].charAt(indexM + 1) == '#')
        return true;

    return false;
}

function isUpShip(B: string[], indexN: number, indexM: number): boolean {
    if (indexN - 1 > 0 && B[indexN - 1].charAt(indexM) == '#')
        return true;

    return false;
}

function isDownShip(B: string[], N: number, indexN: number, indexM: number): boolean {
    if (indexN + 1 < N && B[indexN + 1].charAt(indexM) == '#')
        return true;

    return false;
}

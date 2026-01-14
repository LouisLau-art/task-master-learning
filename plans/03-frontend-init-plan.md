# Implementation Plan: Frontend Init and Task List

**Feature**: Frontend Initialization
**Spec**: `specs/03-frontend-init-and-list.md`

## 1. Backend Fix: CORS
- Add `@CrossOrigin` to `TaskController` to allow the frontend to access the API.

## 2. Frontend Project Setup
- Use `bun create vite frontend --template vue-ts` to scaffold the project.
- Move frontend files to the root directory or a subfolder (we'll use `todo-web` folder).
- Install dependencies: `bun add axios`.

## 3. Component Development
- Create `App.vue` (or a dedicated `TaskList.vue`).
- Use `axios.get()` inside `onMounted`.
- Store the results in a `ref`.
- Use `v-for` to render the list in HTML.

## 4. Verification
1. Run backend (8081).
2. Run frontend (`bun dev`).
3. Verify the browser shows tasks fetched from the database.

package tech.springcorps.secureapp.repository.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import tech.springcorps.secureapp.domain.Role;
import tech.springcorps.secureapp.exception.ApiException;
import tech.springcorps.secureapp.repository.RoleRepository;
import tech.springcorps.secureapp.rowMapper.RoleRowMapper;

import java.util.Collection;
import java.util.Map;

import static java.util.Objects.requireNonNull;
import static tech.springcorps.secureapp.enumeration.RoleType.ROLE_USER;
import static tech.springcorps.secureapp.query.RoleQuery.*;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RoleRepositoryImpl implements RoleRepository<Role> {
    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public Role create(Role data) {
        return null;
    }

    @Override
    public Collection<Role> list(int page, int pageSize) {
        return null;
    }

    @Override
    public Role get(Long id) {
        return null;
    }

    @Override
    public Role update(Role data) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    @Override
    public void addRoleToUser(Long userId, String roleName) {
        log.info("Adding role {} to user id: {}", roleName, userId);
        try{
            Role role = jdbc.queryForObject(SELECT_ROLE_BY_NAME_QUERY, Map.of("name", roleName), new RoleRowMapper());
            jdbc.update(INSERT_ROLE_TO_USER_QUERY, Map.of("userId", userId, "roleId", requireNonNull(role).getId()));
        }catch (EmptyResultDataAccessException exception) {
            throw new ApiException("No role found by name :" + ROLE_USER.name());
        } catch (Exception exception){
            throw new ApiException("An error occurred. Please try again.");
        }
    }

    @Override
    public Role getRoleByUserId(Long userId) {
        return null;
    }

    @Override
    public Role getRoleByUserEmail(String email) {
        return null;
    }

    @Override
    public void updateUserRole(Long userId, String roleName) {

    }
}
